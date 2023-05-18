import javax.sound.sampled.*;

public class SoundPlayer implements Runnable { // need runnable for any multi-threaded based implementations
    private String filename;

    public SoundPlayer(String filename) {
        this.filename = filename;
    }
// runs on different thread granted .WAV files are in same folder as game to reduce lag
    public void run() {
        try {
            AudioInputStream channel = AudioSystem.getAudioInputStream(getClass().getResource(filename)); // gets audio content
            AudioFormat formatter = channel.getFormat(); // gets formatter
            DataLine.Info content = new DataLine.Info(SourceDataLine.class, formatter); // applies appropriate formatter
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(content); // 14 and 15: creates and opens data line
            line.open(formatter);
            line.start();
            byte[] buffer = new byte[4096]; // read buffer
            int bytesRead;
            while ((bytesRead = channel.read(buffer)) != -1) { // read loop with buffer to smoothen it even if it adds slight latency
                line.write(buffer, 0, bytesRead);
            }
            line.drain();
            line.close(); // first waits for sound to end then closes
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playSound(String filename) { // takes string of file plus file extension as input
        SoundPlayer player = new SoundPlayer(filename); // object
        Thread thread = new Thread(player);
        thread.start();
    }
}