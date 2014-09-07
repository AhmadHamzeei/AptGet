public class AptGet {

	public static void main(String[] args) {
		AptGetProcess appProcess = new AptGetProcess();
		AptGetWindow appWindow = new AptGetWindow(appProcess);
		appProcess.setAppWindow(appWindow);
	}

}
