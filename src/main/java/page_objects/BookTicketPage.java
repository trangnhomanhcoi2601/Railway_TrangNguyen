package page_objects;

import com.logigear.control.common.imp.Button;
import common.Constants;
import common.Ticket;
import com.logigear.control.common.imp.ComboBox;

public class BookTicketPage extends BasePage {

    //Locators
    private ComboBox cboDepartDate = new ComboBox("css=select[name = 'Date']");
    private ComboBox cboDepartFrom = new ComboBox("css=select[name = 'DepartStation']");
    private ComboBox cboArriveAt = new ComboBox("css=select[name='ArriveStation']");
    private ComboBox cboSeatType = new ComboBox("css=select[name = 'SeatType']");
    private ComboBox cboTicketAmount = new ComboBox("css=select[name = 'TicketAmount']");
    private Button btnBookTicket = new Button("css=input[value='Book ticket']");

    //Methods
    public void selectDepartDate(String date) {
        cboDepartDate.select(date);
    }

    public void selectDepartFrom(String departStation) {
        cboDepartFrom.select(departStation);
    }

    public void selectArriveAt(String arriveStation) {
        cboArriveAt.waitForStalenessOfElement(Constants.WAIT_TIME);
        cboArriveAt.select(arriveStation);
    }

    public void selectSeatType(String seatType) {
        cboSeatType.select(seatType);
    }

    public void selectTicketAmount(String ticketAmount) {
        cboTicketAmount.select(ticketAmount);
    }

    public void bookTicket(Ticket ticket) {
        btnBookTicket.scrollToView();
        this.selectDepartDate(ticket.getDepartDate());
        this.selectDepartFrom(ticket.getDepartFrom());
        this.selectArriveAt(ticket.getArriveAt());
        this.selectSeatType(ticket.getSeatType());
        this.selectTicketAmount(ticket.getTicketAmount());
        btnBookTicket.click();
    }
}