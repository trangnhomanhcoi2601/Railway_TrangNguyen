package page_objects;

import common.Constants;
import common.Ticket;
import helpers.DriverHelper;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends BasePage {
    //Locators
    private By drpDepartDate = By.cssSelector("select[name = 'Date']");
    private By drpDepartFrom = By.cssSelector("select[name = 'DepartStation']");
    private By drpArriveAt = By.cssSelector("select[name='ArriveStation']");
    private By drpSeatType = By.cssSelector("select[name = 'SeatType']");
    private By drpTicketAmount = By.cssSelector("select[name = 'TicketAmount']");
    private By btnBookticket = By.cssSelector("input[value='Book ticket']");

    //Elements
    private Select getDrpDepartDate() {
        return new Select(DriverHelper.getDriver().findElement(drpDepartDate));
    }

    private Select getDrpDepartFrom() {
        return new Select(DriverHelper.getDriver().findElement(drpDepartFrom));
    }

    private Select getDrpArriveAt() {
        return new Select(DriverHelper.getDriver().findElement(drpArriveAt));
    }

    private Select getDrpSeatType() {
        return new Select(DriverHelper.getDriver().findElement(drpSeatType));
    }

    private Select getDrpTicketAmount() {
        return new Select(DriverHelper.getDriver().findElement(drpTicketAmount));
    }

    private WebElement getBtnBookticket() {
        return DriverHelper.getDriver().findElement(btnBookticket);
    }

    //Methods
    public void selectDepartDate(String date) {
        getDrpDepartDate().selectByVisibleText(date);
    }

    public void selectDepartFrom(String departStation) {
        getDrpDepartFrom().selectByVisibleText(departStation);
    }

    public void selectArriveAt(String arriveStation) {
        try {
            getDrpArriveAt().selectByVisibleText(arriveStation);
            Wait.untilElementIsSelected(DriverHelper.getDriver().findElement(drpArriveAt), Constants.TIME_WAIT);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            getDrpArriveAt().selectByVisibleText(arriveStation);
        }
    }

    public void selectSeatType(String seatType) {
        getDrpSeatType().selectByVisibleText(seatType);
    }

    public void selectTicketAmount(String ticketAmount) {
        getDrpTicketAmount().selectByVisibleText(ticketAmount);
    }

    public void bookTicket(Ticket ticket) {
        ElementHelper.scrollToView(this.getBtnBookticket());
        this.selectDepartDate(ticket.getDepartDate());
        this.selectDepartFrom(ticket.getDepartFrom());
        this.selectArriveAt(ticket.getArriveAt());
        this.selectSeatType(ticket.getSeatType());
        this.selectTicketAmount(ticket.getTicketAmount());
        this.getBtnBookticket().click();
    }
}