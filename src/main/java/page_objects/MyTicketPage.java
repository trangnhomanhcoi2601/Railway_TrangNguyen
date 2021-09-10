package page_objects;

import com.logigear.driver.DriverUtils;
import common.Ticket;
import com.logigear.control.common.imp.Label;

public class MyTicketPage extends BasePage {

    //Locators
    private final Label btnCancel = new Label("//table[@class='MyTable']/tbody/tr//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/input[@value='Cancel']");

    //Methods
    public void cancelTicket(Ticket ticket) {
        btnCancel.setDynamicValue(ticket.getDepartFrom(), ticket.getArriveAt());
        btnCancel.scrollToView();
        btnCancel.click();
        DriverUtils.acceptAlert();
    }

    public boolean doesTicketDisplay(Ticket ticket) {
        btnCancel.setDynamicValue(ticket.getDepartFrom(), ticket.getArriveAt());
        btnCancel.waitForDisappear();
        return btnCancel.isVisible();
    }
}