let rank = ["jack", "queen", "king", "six", "seven", "eight", "nine", "ten", "ace"]; //2,3,4,6,7,8,9,10,11
let card_value = [2, 3, 4, 6, 7, 8, 9, 10, 11];
let score1 = 0;
let score2 = 0;

function Cards_and_Value() {

    let cards;
    for (let i = 0; i < card_value.length; i++) {
        cards = [
            {
                name: rank[i] + " diamonds",
                value: card_value[i]
            },
            {
                name: rank[i] + " clubs",
                value: card_value[i]
            },
            {
                name: rank[i] + " hearts",
                value: card_value[i]
            },
            {
                name: rank[i] + " spades",
                value: card_value[i]
            }
        ];
    }
    alert(cards[1]);
}
function shuffle(cards) {
    let currentIndex = cards.length, temporaryValue, randomIndex;

    while (0 !== currentIndex) {

        randomIndex = Math.floor(Math.random() * currentIndex);
        currentIndex -= 1;

        temporaryValue = cards[currentIndex];
        cards[currentIndex] = cards[randomIndex];
        cards[randomIndex] = temporaryValue;
    }
    return cards;
}
function GetCards(cards) {
    let your_cards;
    your_cards.add(cards[1]);

}
