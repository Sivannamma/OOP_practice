package Serializable;
import java.io.*; 
  
class Car implements Serializable 
{ 	
	public int id; 
    public String name; 
    public String f;
  
    public Car(int id, String name) 
    { 
        this.id = id; 
        this.name = name; 
    }

	@Override
	public String toString() 
	{
		return "name: " + name + ", id: " + id;
	} 
  
} 