import java.lang.*;

public class Customer{
  String name;
  String contact;
  String address;
  int customer_id;
	public Customer() { }
	public Customer ( String na,String con,String ad,int customer_id){
     name = na;
     contact = con;
     address = ad;
     customer_id = customer_id;
     }
	public String getName() {
     return name;
    }
	public void setName(String s){
     name = s;
    }
	public String getContact() {
     return contact;
    }
	public void setContact(String s){
     contact = s;
    }
  public String getAddress() {
       return address;
      }
  public void setAddress(String s){
       address = s;
      }
  public int getCustomerID() {
         return customer_id;
      }
  public void setCustomerID(int s){
         customer_id = s;
      }
	public void print(){
     System.out.println("Customer Name=" + name);
     System.out.println("Address=" + address);
     System.out.println("contact=" + contact);
     System.out.println("Customer_ID=" + customer_id);
   }
};
