package chatsystem.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class UDPServer extends Thread{
    
    private int port;
    private final List<Observer> observers = new ArrayList<>();
    
    public UDPServer(int port){
        this.port = port;
    }

    public void addObserver(Observer obs) {
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
/*/
                    synchronized (this.observers) {
                        for (Observer obs : this.observers) {
                            obs.handle(received);
                        }
                    }*/
                }
                

            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
}
