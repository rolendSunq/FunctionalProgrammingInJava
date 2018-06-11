package chapter5.part05.class_for_resource_cleanup;

public class FileWriterEAMTestMain {
	public static void main(String[] args) throws Exception {
		FileWriterEAM.use("eam.txt", writerEAM -> writerEAM.writeStuff("sweet"));
	}
}
