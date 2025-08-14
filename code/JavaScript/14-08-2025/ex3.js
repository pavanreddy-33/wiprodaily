class Util{
    
    getTodayDate(){
        const day =new Date();
        const dd=day.getDate();
        const mm=day.getMonth()+1;
        const yyyy=day.getFullYear();
        return `${dd}-${mm}-${yyyy}`;
    }

    getPIValue(){
        return Math.PI;
    }

    convertC2F(cel){
        return (cel* 9/5)+32;
    }

    getFibonaci(num){
        if(num<=0) return [];
        if(num===1) return [0];
        let fib=[0,1];
        for(let i=2;i<num;i++){
            fib.push(fib[i-1]+fib[i-2]);
        }
        return fib;
    }
}

let util=new Util();
console.log(util.getTodayDate());     
console.log(util.getPIValue());     
console.log(util.convertC2F(15));  
console.log(util.getFibonaci(4));