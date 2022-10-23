class BrowserHistory {

    Deque<String> back = new ArrayDeque<>();
    Deque<String> forward = new ArrayDeque<>();

    String curr;
    public BrowserHistory(String homepage) {
        curr = homepage;
    }
    
    public void visit(String url) {
        back.push(curr);
        curr = url;
        forward.clear();
    }
    
    public String back(int steps) {
        if(steps>back.size())
        {
            while(!back.isEmpty())
            {
                forward.push(curr);
                curr = back.pop();
            }
            return curr;
        }
        for(int i=0; i<steps; i++) 
        {
            forward.push(curr);
            curr = back.pop();            
        }
        return curr;
    }
    
    public String forward(int steps) {
        if(steps>forward.size())
        {
            while(!forward.isEmpty())
            {
                back.push(curr);
                curr = forward.pop();
            }
            return curr;
        }
        for(int i=0; i<steps; i++) 
        {
            back.push(curr);
            curr = forward.pop();            
        }
        return curr;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */