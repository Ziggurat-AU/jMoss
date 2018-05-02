package View;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

class Item{
    int Id;
    String Title;
    boolean Authenticated;

    public Item(int id,String title,boolean authenticated){
       Id = id;
        Title = title;
       Authenticated = authenticated;
   } 
}

public class Menu {
    List<Item> menuItems;

    
    public void initial() {
        menuItems = new ArrayList<Item>();
        menuItems.add(new Item(1,"Login",true));
        menuItems.add(new Item(2,"Add",false));
        menuItems.add(new Item(3,"Edit",false));
        menuItems.add(new Item(4,"Search",false));
        menuItems.add(new Item(5,"Book",false));
        menuItems.add(new Item(6,"List",true));
        menuItems.add(new Item(7,"Logout",false));
        menuItems.add(new Item(8,"Exit",true));
    }

    public void AuthenticatedLogin(){
        for (Iterator<Item> items = menuItems.iterator(); items.hasNext();)
        {
            Item item = items.next();
            item.Authenticated = true;
        }
        menuItems.get(0).Authenticated = false;
        menuItems.get(menuItems.size() - 1).Authenticated = false;
    }

    public void LogOut(){
        for (Iterator<Item> items = menuItems.iterator(); items.hasNext();)
        {
            Item item = items.next();
            item.Authenticated = false;
        }
        menuItems.get(0).Authenticated = true;
        menuItems.get(5).Authenticated = true;
        menuItems.get(menuItems.size() - 1).Authenticated = true;
    }

    public void show() {
        System.out.println("");
        System.out.println("jMOSS - Select Items");
        System.out.println("--------------------");
        for (Iterator<Item> items = menuItems.iterator(); items.hasNext();)
        {
            Item item = items.next();
            if (item.Authenticated){
                System.out.println(item.Id + " " + item.Title);
            }
        }
    }
}
