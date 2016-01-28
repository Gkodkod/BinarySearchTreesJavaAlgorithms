package com.BusiWave.ChallengingHacks;

/**
* @author Gal Levinshtein 
* @since 1/20/2010
* @version 0.01
* 
* This class provides simple implementation of HashMap (without using java api's)-
* Allowing us to store data in key-value pair form.
* insertion order of key-value pairs is not maintained.
* If the map already contains a mapping for the key, the old value is replaced.
* Implementation overwrites <K, V> where K already exists on HashMapSimple.
* Note: A Multimap for example can be implemented to extend this further 
* 		to allow for insertion of different values for the same key 
* 		& I'll leave that to the F2F interview.
* Note: method does not allow you to put null key though it allows null values.
* Implementation allows you to put custom objects as a key as well.
* 
* Key Features: 
*  implementation provides you with following features:
*  >provide complete functionality how to override equals method.
*  >provide complete functionality how to override hashCode method.
* 
* @param <K>
* @param <V>
*/
class HashMapSimple<K, V> {
    
    private Entry<K,V>[] table;   //Array of Entry.
    private int capacity= 7;  //Initial capacity of HashMap
    
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K,V> next;
    
        public Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    

   @SuppressWarnings("unchecked")
   public HashMapSimple(){
      table = new Entry[capacity];
   }

  

   /**
    * Method allows you put key-value pair in HashMapSimple.
    *  
    * @param newKey
    * @param value
    */
   public void put(K newKey, V value){
      if(newKey==null)
          return;    //does not allow to store null K.
     
      //calculate hash of key.
      int hash=hash(newKey);
      //System.out.println("Hash = " + hash);

      //create new entry.
      Entry<K,V> newEntry = new Entry<K,V>(newKey, value, null);
          
      //if table location does not contain any entries, store entry there.
       if(table[hash] == null){
    	   table[hash] = newEntry;
    	   System.out.println("Storing (K,V) = (" + newKey + "," + value + ")");
       }
       else
       {
          Entry<K,V> previous = null;
          Entry<K,V> current = table[hash];
          System.out.println("Storing (K,V) = (" + newKey + "," + value + ")");
          while(current != null) //we have reached last entry of bucket.
          { 
        	  if(current.key.equals(newKey)){          
        		  System.out.println("duplicate key value pair, replacing existing (K,V) = (" + 
        				  			newKey + "," + current.value + ") with value " + value);
        		  if(previous==null){  //node has to be insert on first of bucket.
                    newEntry.next=current.next;
                    table[hash]=newEntry;
                    return;
              }
              else{
            	  
                  newEntry.next=current.next;
                  previous.next=newEntry;
                  return;
              }
          }
          previous=current;
          current = current.next;
        }
        previous.next = newEntry;
       }
   }

   /**
    * Method returns value corresponding to key.
    * @param key
    */
   public V get(K key){
       int hash = hash(key);
       if(table[hash] == null){
        return null;
       }else{
        Entry<K,V> temp = table[hash];
        while(temp!= null){
            if(temp.key.equals(key))
                return temp.value;
            temp = temp.next; //return value corresponding to key.
        }         
        return null;   //returns null if key is not found.
       }
   }


   /**
    * Method removes key-value pair from HashMapCustom.
    * @param key
    */
   public boolean remove(K deleteKey){
      
      int hash=hash(deleteKey);
             
     if(table[hash] == null){
           return false;
     }else{
       Entry<K,V> previous = null;
       Entry<K,V> current = table[hash];
       
       while(current != null){ //we have reached last entry node of bucket.
          if(current.key.equals(deleteKey)){               
              if(previous==null){  //delete first entry node.
                    table[hash]=table[hash].next;
                    return true;
              }
              else{
                    previous.next=current.next;
                     return true;
              }
          }
          previous=current;
            current = current.next;
         }
       return false;
     }
   
   }
  

   /**
    * Method prints all key-value pairs present in HashMapSimple.
    * @param key
    */
   public void print(){
      
	  System.out.print("Printing hashMapSimple : ");
      for(int i=0;i<capacity;i++){
          if(table[i]!=null){
                 Entry<K, V> entry=table[i];
                 while(entry!=null){
                       System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
                       entry=entry.next;
                 }
          }
      }
      System.out.println("\n");
   
   }
   /**
    * Method implements hashing functionality, which helps in finding the appropriate
    * bucket location to store our data.
    * This is very important method, as performance of HashMapSimple is very much
    * dependent on  this method's implementation.
    * @param key
    */
   private int hash(K key){
       return Math.abs(key.hashCode()) % capacity;
   }

}


/**
* Main class- to test simple HashMap functionality.
*/
public class HashMapSimpleApp {
    
   public static void main(String[] args) {
	   	  HashMapSimple<Integer, Integer> hashMapSimple = new HashMapSimple<Integer, Integer>();
          hashMapSimple.put(12, 11);
          hashMapSimple.put(25, 120);
          hashMapSimple.put(30, 150);
          hashMapSimple.put(33, 15);
          hashMapSimple.put(35, 86);
          hashMapSimple.put(25, 11111);  // this will overwrite previous insertion of (25, 120)
          hashMapSimple.put(45, null);
          hashMapSimple.put(9, 101);
          

          System.out.println("\nvalue of key 12 =" + hashMapSimple.get(12));
          System.out.println("value of key 33 =" + hashMapSimple.get(33));
           
          hashMapSimple.print();

          System.out.println("value corresponding to key 30 removed: " + hashMapSimple.remove(30));
          System.out.println("value corresponding to key 45 removed: " + hashMapSimple.remove(45));

          hashMapSimple.print();

   }
}

/*Output

Storing (K,V) = (12,11)
Storing (K,V) = (25,120)
Storing (K,V) = (30,150)
Storing (K,V) = (33,15)
Storing (K,V) = (35,86)
Storing (K,V) = (25,11111)
duplicate key value pair, replacing existing (K,V) = (25,120) with value 11111
Storing (K,V) = (45,null)
Storing (K,V) = (9,101)

value of key 12 =11
value of key 33 =15
Printing hashMapSimple : {35=86} {30=150} {9=101} {45=null} {25=11111} {12=11} {33=15} 

value corresponding to key 30 removed: true
value corresponding to key 45 removed: true
Printing hashMapSimple : {35=86} {9=101} {25=11111} {12=11} {33=15} 

*/
