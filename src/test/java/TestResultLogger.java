import log.Log;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestResultLogger implements TestWatcher {

    Log log =new Log();

    @Override
    public void testSuccessful(ExtensionContext context) {
        String method= context.getDisplayName();
        log.info(method+"Passed");
    }
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String method= context.getDisplayName();
        log.info(method+"Failed");
    }
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }



    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }
}
