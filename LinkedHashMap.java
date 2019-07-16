package com.accolite.au.java;
public class LinkedHashMap {
        private Entry[] buckets;
        private int capacity=4;
        private Entry head;
        private Entry tail;
        static class Entry
        {
            Integer key;
            Integer value;
            Entry next;
            Entry before;
            Entry after;
            public Entry(Integer key ,Integer value,Entry next)
            {
                this.key=key;
                this.value=value;
                this.next=next;
            }   
        }
        public LinkedHashMap()
        {
            buckets=new Entry[capacity];    
        }
        public void put(Integer key,Integer value)
        {
            if(key==null)//not allow null key
            {
                return;
            }
            boolean replace=false;
            int hash=hash(key);
            Entry newEntry = new Entry(key, value, null);
            //insert in bucket
        //  maintainOrderAfterInsert(newEntry);  
            Entry curr=buckets[hash];

            if(curr==null)
            {
              buckets[hash]=newEntry;
            }
            else
            {
                Entry prev=null;
            while(curr!=null)
            {
                if(curr.key.equals(key))
                {
                    replace=true;
                    curr.value=value;
                    break;
                }
                prev=curr;
                curr=curr.next;
            }
             if(prev!=null)
             prev.next=newEntry;
            }
            //newEntry.next=curr;
            //buckets[hash]=newEntry;
            if(replace==false)
            insertInList(newEntry);
            //buckets[hash]=newEntry;
        }
        private void insertInList(Entry newEntry)
        {
            if(head==null)
            {
                head=newEntry;
                tail=newEntry;
            }
            else
            {
              tail.after=newEntry;
              newEntry.before=tail;
              tail=newEntry;
            }
        }
        public Integer get(Integer key)
        {   
            int hash=hash(key);
            Entry curr=buckets[hash];
            while(curr!=null)
            {
                if(curr.key.equals(key))
                {
                    return curr.value;
                }
                curr=curr.next;
            }
            return null;
        }

        public void print()
        {
            Entry curr=head;
            while(curr!=null)
            {
              System.out.println("key is "+ curr.key+"val is "+ curr.value+"->");   
              curr=curr.after;
            }
        }   
        private int hash(Integer key){
            return Math.abs(key.hashCode()) % capacity;
        }

        public void remove(Integer key)
        {
            int hash=hash(key);
            Entry curr=buckets[hash];
            if(curr==null)//no exist
            {
                return;
            }
            Entry p=null;
            Entry n;
            while(curr!=null)
            {
                n=curr.next;
                if(curr.key.equals(key))
                {
                   if(p==null)//first
                   {
                       buckets[hash]=buckets[hash].next;
                   }
                   else
                   {
                       p.next=n;
                   }
                   //adjust Linked List
                   adjustList(curr);
                   break;
                }
                p=curr;
                curr=n;
            }

        }
        private void adjustList(Entry curr)
        {
            if(curr==head)
            {
                head=head.after;
                if(head==null)
                {
                    tail=null;
                }
            }
            else if (curr==tail)
            {
                tail=tail.before;
                tail.after=null;
            }
            else
            {
                curr.before.after=curr.after;
                curr.after.before=curr.before;
            }
        }
        public void deleteAll()
        {
            head=null;
            tail=null;
            for(int i=0;i<capacity;i++)
            {
                buckets[i]=null;
            }   
        }
        public static void main(String []args)
        {
        	LinkedHashMap instance = new LinkedHashMap();
        	instance.put(1,20 );
        	instance.put(2,21 );
        	instance.put(3,22 );
        	instance.put(4,23 );
        	instance.put(5,40);
        	instance.print();
        	System.out.println("has of key 1"+instance.hash(1));
        	instance.remove(3);
        	instance.print();
        	
        	
        }
}
