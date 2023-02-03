package com.example.safe;


import com.example.safe.repeaters.IRepeater;

public class SafeInvoker implements SafeInvoking{
    private final IRepeater repeater;

    public SafeInvoker(IRepeater repeater) {
        this.repeater = repeater;
    }


    @Override
    public InvokerResult SafeInvoke(NotSafeAction action) {
        try{
            return new InvokerResult(null, true);
        }catch(Exception ex){
            repeater.For(ex);
            while(repeater.shouldRetry()){
                try{
                    return new InvokerResult(null, true);
                }
                catch(Exception ex2){
                    repeater.For(ex2).waiting().retry();
                    if(!repeater.shouldRetry()) return new InvokerResult(ex2, false);
                }
            }
        }
        return null;
    }
}
