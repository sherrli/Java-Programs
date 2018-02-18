public class Dictionary implements DictionaryInterface{
   // private inner Node class
   private class Node{
      String key;
      String value;
      Node next;
      Node(String k, String v){
         key = k;
         value = v;
         next = null;
      }
   }

   // fields for Dictionary class
   private Node head;
   private Node tail;
   private int numItems;

   // Dictionary()
   // constructor for the Dictionary class
   public Dictionary(){
      head = null;
      tail = null; // add a tail pointer to save runtime
      numItems = 0;
   }

   // private helper function --------------------------------------------

   // find()
   // returns a reference to the Node containing key in this Dictionary
   // returns null if no such Node exists
   private Node findKey(String key){
      Node N = head;
      while(N != null){
         if( (N.key).equals(key) ){
            return N;
         }
         N = N.next;
      }
      return null;
   }

   // ADT operations -----------------------------------------------------

   // isEmpty()
   // pre: none
   // returns true if this Dictionary is empty, false otherwise
   public boolean isEmpty(){
      return (numItems == 0);
        }

   // size()
   // pre: none
   // returns the number of entries in this Dictionary
   public int size(){
      return numItems;
   }

   // lookup()
   // pre: none
   // returns value associated key, or null reference if no such key exists
   public String lookup(String key){
      Node N = findKey(key);
      if(N != null){
         return N.value;
      }else{
         return null;
      }
   }

   // insert()
   // inserts new (key,value) pair into this Dictionary
   // pre: lookup(key)==null
   public void insert(String key, String value) throws DuplicateKeyException{
      if(lookup(key) != null){ // throw the exception to the calling function
         throw new DuplicateKeyException("cannot insert duplicate keys");
      }
      if(head == null){ // special case: Dictionary is empty
         head = new Node(key, value);
         tail = head;
      }else{ // insert to end of list
         tail.next = new Node(key, value);
         tail = tail.next;
      }
      numItems++;
   }

   // delete()
   // deletes pair with the given key
   // pre: lookup(key)!=null
   public void delete(String key) throws KeyNotFoundException{
      Node N = findKey(key);
      if(N == null){ // throw the exception to the higher function
         throw new KeyNotFoundException("cannot delete non-existent key");
      }

      // special case: delete head item
      if(head == N){
         head = head.next;
      }else{
         Node P = null;
         Node C = head;
         while(C != N){
            P = C;
            C = C.next;
         }

         P.next = C.next;
         C.next = null;
      }
      numItems--;
   }

   // makeEmpty()
   // pre: none
   public void makeEmpty(){
      head = null;
      tail = null;
      numItems = 0;
   }

   // toString()
   // returns a String representation of this Dictionary
   // overrides Object's toString() method
   // pre: none
   public String toString(){
      // create a stringbuffer object default capacity 16 characters
      StringBuffer sb = new StringBuffer();
      // append each string as we go along the list
      for(Node N = head; N!=null; N=N.next){
         sb.append(N.key + " ").append(N.value + "\n");
      }
      return new String(sb);
   }

}
