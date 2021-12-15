package tests;

import org.testng.annotations.Test;

public class ActionTests extends TestBase{

    @Test
    public void actionTest(){
        app.action().selectInteractions();
        app.action().selectDroppable();
        app.action().droppebleTests();

    }
}
