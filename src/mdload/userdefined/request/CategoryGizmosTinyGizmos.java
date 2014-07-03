package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryGizmosTinyGizmos extends Request {
public CategoryGizmosTinyGizmos() {
	super();
}

@Override
public long action( WebDriver driver ) {
	long in = System.currentTimeMillis();
	driver.findElement(By.linkText("Tiny Gizmo")).click();
	return System.currentTimeMillis() - in;
}
}