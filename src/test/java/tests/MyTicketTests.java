package tests;

import common.Ticket;
import helpers.DataHelper;
import helpers.DateHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;
import page_objects.MyTicketPage;
import page_objects.RegisterPage;

public class MyTicketTests extends BaseTests{
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    RegisterPage registerPage = new RegisterPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    private final String email = DataHelper.getRandomEmail();
    private final String password = "123456789";
    private final String pid = "123456789";
    private final String departDay = DateHelper.getDayFromToday(10);
    private final String departFrom = "Đà Nẵng";
    private final String arriveAt = "Huế";
    private final String seatType = "Soft bed";
    private final String ticketAmount = "1";

    @BeforeMethod
    public void preCondition() {
        registerPage.goToRegisterPage();
        registerPage.register(email, password, password, pid);
    }

   @Test(description = "User can cancel a ticket")
    public void tc016_UserCanCancelTicket() {
        LogHelper.info("Login with valid account");
        loginPage.goToLoginPage();
        loginPage.login(email, password);

        LogHelper.info("Go to Book Ticket page");
        bookTicketPage.goToBookticketPage();

        LogHelper.info("Set value of fields for ticket");
        Ticket ticket = new Ticket();
        ticket.setDepartDate(departDay);
        ticket.setDepartFrom(departFrom);
        ticket.setArriveAt(arriveAt);
        ticket.setSeatType(seatType);
        ticket.setTicketAmount(ticketAmount);

        LogHelper.info("Book a ticket");
        bookTicketPage.bookTicket(ticket);

        LogHelper.info("Go to My Ticket page");
        myTicketPage.goToMyticketPage();

        LogHelper.info("Cancel a ticket");
        myTicketPage.cancelTicket();

        LogHelper.info("Check if the canceled ticket is disappeared");
        Assert.assertFalse(myTicketPage.isTicketDeleted(),"The canceled ticket is appeared" );
    }
}