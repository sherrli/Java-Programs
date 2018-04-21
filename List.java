 int back(){
                if(this.length()==0){
                        throw new RuntimeException(
                                "List Error: back() called on empty List");
                }
                return back.data;
        }

        // get()
        // Returns cursor element
        // Pre: length()>0, index()>=0
        int get(){
                if(this.length()==0){
                        throw new RuntimeException(
                                "List Error: get() called on empty List");
                }
                if(this.index()<0){
                        throw new RuntimeException(
                                "List Error: get() called on undefined cursor");
                }
                return cursor.data;
        }

        // equals()
        // Returns true only if this List and L are the same integer sequence
        // cursors are not compared
        boolean equals(List L){
                boolean eq = true;
                if(this.length() != L.length()){
                        return false;
                }
                Node N = this.front;
                Node M = L.front;
                while(eq && N!=null){
                        eq = N.equals(M);
                        N = N.next;
                        M = M.next;
                }
                return eq;
        }

        // Manipulation Procedures-----------------
        // clear()
        // Resets this List to the empty state
        void clear(){
                front = null;
                back = null;
                cursor = null;
                length = 0;
