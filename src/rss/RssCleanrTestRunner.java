package rss;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class RssCleanrTestRunner {

	public static void main(String[] args) {
		org.junit.runner.Result result = JUnitCore
				.runClasses(RssCleanrTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("all done! testing complete!");

	}
}

