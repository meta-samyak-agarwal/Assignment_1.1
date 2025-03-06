import java.util.* ;

public class Main{

    public static HashMap<Item , Integer> map = new HashMap<>() ;

    static class Item{   // a constructor for the item creation
        int id ;
        String name ;
        String Description ;
        int price ;

        public Item(int id , String name , String Description , int price)
        {
            this.id = id ;
            this.name = name ;
            this.Description = Description ;
            this.price = price ;
        }
    }

    static void addToCart(Item item , int quantity)
    {
        if(map.containsKey(item)){                      // if present then update else put new
            map.put(item, quantity+map.get(item)) ;
        }
        else {
            map.put(item,quantity) ;
        }
  
    }

    static int displayQuantity(Item item)
    {
        if(map.containsKey(item))
            return map.get(item) ;
        else 
            return 0 ;
    }


    static void deleteItem(Item item)
    {
        map.remove(item) ;
    }

    static void updateQuantity(Item item , Integer quantity)
    { 
        int oldQuantity = map.get(item) ;

        map.put(item , oldQuantity + quantity ) ; 
    }


    static double displayBill()
    {
        double sum = 0 ;

        for(Map.Entry<Item,Integer> it : map.entrySet())
        {
            Item tempItem = it.getKey() ;
            int quantity = it.getValue() ;

            sum += tempItem.price * quantity ;
        }

        return sum ;
    }


    public static void main(String[] args) 
    {

        Item item1 = new Item(1 , "item1" , "desc1" , 12) ;
        Item item2 = new Item(2 , "item2" , "desc2" , 13) ;
        Item item3 = new Item(3 , "item3" , "desc3" , 14) ;
        Item item4 = new Item(4 , "item4" , "desc4" , 15) ;

        Scanner sc = new Scanner(System.in) ;

        while(true)
        {

            System.out.println("welcome to the shopping cart");
            System.out.println("1. add Items in your cart ");
            System.out.println("2. display quantity of item");
            System.out.println("3. update quantity of the item ");
            System.out.println("4. delete Item in your cart ");
            System.out.println("5. get the bill of your cart");
            System.out.println("6. exit shopping");

            System.out.println("enter your choice") ;
            int choice = sc.nextInt() ;
            
            if(choice == 1)
            {
                System.out.println("1) item1");
                System.out.println("2) item2");
                System.out.println("3) item3");
                System.out.println("4) item4");

                System.out.println("Enter your choice");
                int choice2 = sc.nextInt() ;

                System.out.println("enter the quantity of the selected item");
                int quan = sc.nextInt() ;

                if(choice2 == 1){
                    addToCart(item1, quan);
                }else if(choice2 == 2){
                    addToCart(item2, quan);
                }else if(choice2 == 3){
                    addToCart(item3, quan);
                }else if(choice2 == 4){
                    addToCart(item4, quan);
                }
                else System.out.println("wrong key pressed");

                System.out.println("Item added succesfully");

            }else if(choice == 2){
                System.out.println("tell me which item quantity you wanna know");

                System.out.println("1) item1");
                System.out.println("2) item2");
                System.out.println("3) item3");
                System.out.println("4) item4");

                System.out.println("Enter your choice");
                int choice3 = sc.nextInt() ;

                if(choice3 == 1){
                    int q = displayQuantity(item1) ;
                    System.out.println("Your quantity is " + q);
                }else if(choice3 == 2){
                    int q = displayQuantity(item2) ;
                    System.out.println("Your quantity is " + q);
                }else if(choice3 == 3){
                    int q = displayQuantity(item3) ;
                    System.out.println("Your quantity is " + q);
                }else if(choice3 == 4){
                    int q = displayQuantity(item4) ;
                    System.out.println("Your quantity is " + q);
                }
                else System.out.println("wrong key pressed");



            }else if(choice == 3){

                System.out.println("1) item1");
                System.out.println("2) item2");
                System.out.println("3) item3");
                System.out.println("4) item4");

                System.out.println("Enter your choice of item to update");
                int choice3 = sc.nextInt() ;

                System.out.println("enter the quantity of the selected item to increase");
                int quan = sc.nextInt() ;

                if(choice3 == 1){
                    updateQuantity(item1, quan);
                }else if(choice3 == 2){
                    updateQuantity(item2, quan);
                }else if(choice3 == 3){
                    updateQuantity(item3, quan);
                }else if(choice3 == 4){
                    updateQuantity(item4, quan);
                }
                else System.out.println("wrong key pressed");

                System.out.println("Item updated  succesfully");

            }else if(choice == 4){

                System.out.println("1) item1");
                System.out.println("2) item2");
                System.out.println("3) item3");
                System.out.println("4) item4");

                System.out.println("Enter your choice");
                int choice4 = sc.nextInt() ;

                if(choice4 == 1){
                    deleteItem(item1);
                }else if(choice4 == 2){
                    deleteItem(item2);
                }else if(choice4 == 3){
                    deleteItem(item3);
                }else if(choice4 == 4){
                    deleteItem(item4);
                }
                else System.out.println("wrong key pressed");

                System.out.println("Item deleted succesfully");

            }else if(choice == 5){
                double ans = displayBill() ;
                System.out.println("your total bill is  --> " + ans) ; 
            }
            else break ;

        }

    }
}