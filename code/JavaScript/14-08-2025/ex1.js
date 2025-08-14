let array=[1,3,5,2,9,0,2];

const summationfun=(arr)=> arr.reduce((acc,num)=>acc+num,0);

console.log(summationfun(array));