/**
To implement my own hashTable

*/

class myTable{

    public int count = 0;
    private ListNode[] table;

    private static class ListNode{
        String key;
        String value;
        ListNode next;
    }

    public myTable(){
          table = new ListNode[64];
    }

    public myTable(int initialSize){
          if (initialSize <= 0)
              throw new IllegalArgumentException("Illegal table size");
          table = new ListNode[initialSize];
    }



    public void put(String key, String value){
          // asert key null
          assert key != null : "Key must be non-null";
          // location of bucket in table
          int bucket = hash(key);
          // to traverse the linked list to check if key exist
          ListNode list = table[bucket];
          // put value if not reach end
          while(list != null){
            if(list.key.equals(key))
                break;
            list = list.next;
          }
          if(list != null)
              list.value = value;
          // if reach end check if size >= 0.75
          else{
              if (count >= 0.75 * table.length){
                resize();
                // recompute hash code, since bucket depends on hashcode
                // and hashcode depends on table size
                bucket = hash(key);
              }
              ListNode newNode = new ListNode();
              newNode.key = key;
              newNode.value = value;
              newNode.next = table[bucket];
              table[bucket] = newNode;
              count++;
          }
    }

    void dump() {
      System.out.println();
      for (int i = 0; i < table.length; i++) {
             // Print out the location number and the list of
             // key/value pairs in this location.
         System.out.print(i + ":");
         ListNode list = table[i]; // For traversing linked list number i.
         while (list != null) {
            System.out.print("  (" + list.key + "," + list.value + ")");
            list = list.next;
         }
         System.out.println();
      }
   } // end dump()

    public String get(String key){
          // location of bucket
          int bucket = hash(key);
          // create to traverse the list
          ListNode list = table[bucket];
          // return when found
          while(list != null){
              if(list.key.equals(key))
                  return list.value;
              list = list.next;
          }
          // if no found, return null
          return null;
    }

    public boolean containsKey(String key){
          // location of key
          int bucket = hash(key);
          // list to traverse
          ListNode list = table[bucket];
          // when found retutrn true
          while(list != null){
                if(list.key.equals(key))
                    return true;
                list = list.next;
          }
          // if end of list, return false
          return false;
    }

    public void remove(String key){
              // location
              int bucket = hash(key);

              // if null return
              if(table[bucket] == null)
                  return;
              // if equal to 1st in list, no need traverse
              if(table[bucket].key.equals(key)){
                  table[bucket] = table[bucket].next;
                  count--;
              }

              // else, traverse until found and delete

              ListNode prev = table[bucket];
              ListNode curr = prev.next;

              while(curr != null && !curr.key.equals(key)){
                    curr = curr.next;
                    prev = curr;
              }


              if(curr != null){
                    prev.next = curr.next;
                    count--;
              }
    }

    public int size(){
          return count;
    }

    private int hash(Object key){
          return (Math.abs(key.hashCode())) % table.length;
    }

    private void resize(){
          // newtable with double the size
          ListNode[] newTable = new ListNode[table.length*2];
          // for each table
          for(int i = 0; i < table.length; i++){
                ListNode list = table[i];

                while(list != null){
                    ListNode next = list.next;
                    int hash = (Math.abs(list.key.hashCode())) % newTable.length;
                    list.next = newTable[hash];
                    newTable[hash] = list;
                    list = next;
                }
          }
          // traverse each list in the table
          // save list.next
          // take new hash for new table length
          // save newtable[hash] to list.next
          // save list to newtable[hash]
          // replace newtable with oldtable
          table = newTable;
    }// end resize
}
