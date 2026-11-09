package chatsystem.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

import chatsystem.controlleur.Controller;

public class UDPServer extends Thread{
    
    public interface Observer {
        /** Method that is called each time a message is received. */
        void handleMessage(String ip, String received);
    }


    private final int port;
    private final List<Controller> observers = new ArrayList<>();
    
    public UDPServer(int port){
        this.port = port;
    }

    public void addObserver(Controller obs) {
        synchronized (this.observers) {
            this.observers.add(obs);
        }
    }

    @Override
        public void run() {
            try {
                DatagramSocket socket = new DatagramSocket(port);

                byte[] buf = new byte[256];

                while (true) {
                    DatagramPacket inPacket = new DatagramPacket(buf, buf.length);

                    socket.receive(inPacket);

                    String received =
                        new String(
                            inPacket.getData(),
                            0,
                            inPacket.getLength()
                        );

                    synchronized (this.observers) {
                        for (Controller obs : this.observers) {
                            obs.handleMessage(inPacket.getAddress().toString(), received);
                        }
                    }
                }
                

            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
}
