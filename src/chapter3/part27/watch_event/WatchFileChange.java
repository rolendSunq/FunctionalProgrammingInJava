package chapter3.part27.watch_event;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class WatchFileChange {
	public static void main(String[] args) throws IOException, InterruptedException {
		final Path path = Paths.get(".");
		final WatchService watchService = path.getFileSystem().newWatchService();
		
		System.out.println("Report any file changed within next 1 minute...");
		
		final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);
		
		
		if (watchKey != null) {
			watchKey.pollEvents().stream().forEach(event -> System.out.println(event.context()));
		}
		
	}
}
