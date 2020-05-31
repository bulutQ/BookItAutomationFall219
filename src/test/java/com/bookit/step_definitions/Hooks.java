package com.bookit.step_definitions;

import com.bookit.utilities.DBUtility;
import com.bookit.utilities.Driver;
import com.bookit.utilities.Environment;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    /**
     * This hook will be executed only for scenarios that are annotated with @db
     */
    @Before("@db")
    public void dbSetup(){
        DBUtility.createDBConnection(Environment.DB_HOST,Environment.DB_USERNAME,Environment.DB_PASSWORD);
    }

    /**
     * This hook will be executed only for scenarios that are annotated with @db
     */
    @After("@db")
    public void dbTearDown(){
        DBUtility.destroy();
    }

    /**
     * This hook will be executed only for scenarios that are annotated with @ui
     */
    @Before("ui")
    public void uiSetup(){
        Driver.getDriver().manage().window().maximize();
    }

    /**
     * This hook will be executed only for scenarios that are annotated with @ui
     */
    @After("@ui")
    public void uiTearDown(){
        Driver.closeDriver();
    }
}
