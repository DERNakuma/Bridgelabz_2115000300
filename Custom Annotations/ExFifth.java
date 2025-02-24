import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}
class Software {
    @BugReport(description = "Null pointer exception occurs")
    @BugReport(description = "Performance issue on large inputs")
    void fixBugs() {
        System.out.println("Fixing bugs...");
    }
}
public class ExFifth {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("fixBugs");
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
    }
}
