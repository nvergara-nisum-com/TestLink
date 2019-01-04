package com.appium.stepdefinitions;

import bean.User;

import com.appium.example.BaseAppium;
import com.appium.example.Login;
import com.utils.PropertyLoader;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    PropertyLoader loadproperty = new PropertyLoader();
    User user;

    @Given("^Somos usuarios$")
    public void Somos_usuarios() {
        user = new User(loadproperty.loadProperties().getProperty("loginUser"), loadproperty.loadProperties().getProperty("passwordUser"));
    }

    @And("^Ingresamos a la aplicacion$")
    public void Ingresamos_a_la_aplicacion() {
        BaseAppium baseAppium = new BaseAppium();
        try {
            baseAppium.init();
        } catch (Exception e) {
            System.out.println("Error connecting to Appium Service");
        }
    }

    @When("^Escribimos usuario y password$")
    public void Escribimos_usuario_y_password() {
        Login login = new Login();
        login.login(user);
    }

    @Then("^login correcto$")
    public void login_correcto() {

    }
    
    @When("^Escribimos usuario y password incorrectos$")
    public void Escribimos_usuario_y_password_incorrectos() {
        Login login = new Login();
        login.login(user);
    }

    @Then("^login no hecho$")
    public void login_no_hecho() {

    }

    @After
    public void close() {
        BaseAppium baseAppium = new BaseAppium();
        baseAppium.tearDown();
    }

}
