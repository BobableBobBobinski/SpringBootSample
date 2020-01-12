let rank = ["jack", "queen", "king", "six", "seven", "eight", "nine", "ten", "ace"]; //2,3,4,6,7,8,9,10,11
let card_value = [2, 3, 4, 6, 7, 8, 9, 10, 11];
let score1 = 0;
let score2 = 0;

function Cards_and_Value() {

    //alert(rank["six"]);
    for (let i = 0; i < 9; i++) {
        let cards = [
            {
                name: rank[i] + "diamonds",
                value: card_value[i]
            },
            {
                name: rank[i] + "clubs",
                value: card_value[i]
            },
            {
                name: rank[i] + "hearts",
                value: card_value[i]
            },
            {
                name: rank[i] + "spades",
                value: card_value[i]
            }
        ];
    }
}
function GetCards() {
    
}
