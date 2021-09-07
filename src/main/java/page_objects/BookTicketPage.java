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
    private By btnBookTicket = By.cssSelector("input[value='Book ticket']");

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

    private WebElement getBtnBookTicket() {
        return DriverHelper.getDriver().findElement(btnBookTicket);
    }

    //Methods
    public void selectDepartDate(String date) {
        Wait.untilElementIsVisible(drpDepartDate, Constants.TIME_WAIT);
        getDrpDepartDate().selectByVisibleText(date);
    }

    public void selectDepartFrom(String departStation) {
        Wait.untilElementIsVisible(drpDepartFrom, Constants.TIME_WAIT);
        getDrpDepartFrom().selectByVisibleText(departStation);
    }

    public void selectArriveAt(String arriveStation) {
        Wait.untilElementIsVisible(drpArriveAt, Constants.TIME_WAIT);
        getDrpArriveAt().selectByVisibleText(arriveStation);
    }

    public void selectSeatType(String seatType) {
        Wait.untilElementIsVisible(drpSeatType, Constants.TIME_WAIT);
        getDrpSeatType().selectByVisibleText(seatType);
    }

    public void selectTicketAmount(String ticketAmount) {
        Wait.untilElementIsVisible(drpTicketAmount, Constants.TIME_WAIT);
        getDrpTicketAmount().selectByVisibleText(ticketAmount);
    }

    public void bookTicket(Ticket ticket) {
        ElementHelper.scrollToView(this.getBtnBookTicket());
        this.selectDepartDate(ticket.getDepartDate());
        this.selectDepartFrom(ticket.getDepartFrom());
        this.selectArriveAt(ticket.getArriveAt());
        this.selectSeatType(ticket.getSeatType());
        this.selectTicketAmount(ticket.getTicketAmount());
        this.getBtnBookTicket().click();
    }
}