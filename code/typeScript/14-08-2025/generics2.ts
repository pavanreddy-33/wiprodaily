function pair<T,U>(first:T,second:U):[T,U]{
    return [first,second];
}

const firstPair = pair<String,number>("Pavan",33);

const secondPair = pair<boolean,number>(true,33);

console.log(firstPair);
console.log(secondPair);