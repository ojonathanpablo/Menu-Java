/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Usuário
 */
public class Menu extends JComponent {

    private MigLayout layout;
    private String[][] menuItems = new String[][]{
        {"Dashboard"},
        {"Email", "Inbox", "Read", "Compost"},
        {"Chat"},
        {"Calendar"},
        {"UI Kit", "Accordion", "Alerts", "Badges", "Breadcrumbs", "Buttons", "Button group"},
        {"Advanced UI", "Cropper", "Owl Carousel", "Sweet Alert"},
        {"Forms", "Basic Elements", "Advanced Elements", "SEditors", "Wizard"},
        {"Charts", "Apex", "Flot", "Peity", "Sparkline"},
        {"Table", "Basic Tables", "Data Table"},
        {"Icons", "Feather Icons", "Flag Icons", "Mdi Icons"},
        {"Special Pages", "Blank page", "Faq", "Invoice", "Profile", "Pricing", "Timeline"}
    };

    public Menu() {
        init();
    }

    private void init() {
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2","fill");
        setLayout(layout);
        
        // INIT MENUITEM
        for(int i=0; i < menuItems.length ; i++){
            addMenu(menuItems[i][0], i);
        }
        
    }
    
    private void addMenu(String menuName, int index){
        int length = menuItems[index].length;
        MenuItem item = new MenuItem(menuName,index,length>1);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(length>1){
                    addSubMenu(item,index , length, getComponentZOrder(item));
                }
            }
        
        });
        add(item);
        revalidate();
        repaint();
    }
    
    private void addSubMenu(MenuItem item, int index, int length, int indexZorder){
        JPanel panel = new JPanel (new MigLayout("wrap 1, fillx, inset 0, gapy 0","fill"));
        panel.setOpaque(false);
        for(int i=1; i<length;i++){
            MenuItem subItem = new MenuItem(menuItems[index][i], i ,false);
            subItem.initSubMenu(i, length);
            panel.add(subItem);
        }
        add(panel, indexZorder+1);
        revalidate();
        repaint();
        
    }
}
