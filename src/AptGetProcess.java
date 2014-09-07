import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;

import javax.swing.SwingWorker;


public class AptGetProcess extends SwingWorker<Integer, String> {
	private AptGetWindow appWindow;
	private int progressBarValue = 0;
	
	@Override
    protected void process(List<String> chunks) {
		
		for (String value : chunks) {
			if (value != null) {
				appWindow.getTextArea().append(value + "\n");
				appWindow.getProgressBar().setValue(progressBarValue++);
			}
			else {
				appWindow.getProgressBar().setValue(
					appWindow.getProgressBar().getMaximum());
			}
		}
		
	}
	
	@Override
    protected Integer doInBackground() throws Exception {
		int result = -1;
		
        try {
        	String s = null;
        	ProcessBuilder pb = new ProcessBuilder("gksudo", "apt-get", "update");
        	pb.redirectErrorStream(true);
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            do {
            	s = br.readLine();
            	publish(s);
            } while (s != null);
            
            try {
            	result = p.waitFor();
            }
            catch (InterruptedException e) {
            	System.out.println(e);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
		
        return result;
	}
	
	public void setAppWindow(AptGetWindow appWindow) {
		this.appWindow = appWindow;
	}

}
