import javax.swing.*;

public class App {


    public static void main(String[] args) {
        System.out.println("Hello World");

        LiveMatch liveMatch = new LiveMatch();
//        BasicWidgets widgets = new BasicWidgets();
//        widgets.initViews();
        TabbedWidget tabbedWidget = new TabbedWidget();
        tabbedWidget.initViews();
    }

}
