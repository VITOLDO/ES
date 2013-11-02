package com.filonenko.es;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

/**
 * @author: Viktor, Filonenko
 * @since: 30.10.13
 */
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout content = new VerticalLayout();
        content.setSizeFull(); // Use entire window
        setContent(content);   // Attach to the UI

        // Add some component
        content.addComponent(new Label("Hello!"));

        // Layout inside layout
        HorizontalLayout hor = new HorizontalLayout();
        hor.setSizeFull(); // Use all available space

        // Couple of horizontally laid out components
        Tree tree = new Tree("My Tree", new Tree());
        hor.addComponent(tree);

        Table table = new Table("My Table", new Tree());
        table.setSizeFull();
        hor.addComponent(table);
        hor.setExpandRatio(table, 1); // Expand to fill

        content.addComponent(hor);
        content.setExpandRatio(hor, 1); // Expand to fill
    }
}
