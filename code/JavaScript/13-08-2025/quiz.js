const questions = [
    {
        question: "What is the capital of India?",
        options: ["Delhi", "Mumbai", "Chennai", "Kolkata"],
        answer: 0
    },
    {
        question: "Which planet is known as the Red Planet?",
        options: ["Earth", "Mars", "Jupiter", "Venus"],
        answer: 1
    },
    {
        question: "Who wrote 'Hamlet'?",
        options: ["Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"],
        answer: 1
    }
];

let current = 0;
let score = 0;
let answered = false;

function loadQuestion() {
    document.getElementById("feedback").textContent = "";
    answered = false;
    const q = questions[current];
    document.getElementById("question").textContent = q.question;
    const optionsDiv = document.getElementById("options");
    optionsDiv.innerHTML = "";
    q.options.forEach((opt, idx) => {
        const btn = document.createElement("button");
        btn.textContent = opt;
        btn.onclick = function() {
            if (answered) return;
            answered = true;
            if (idx === q.answer) {
                document.getElementById("feedback").textContent = "Correct!";
                score++;
            } else {
                document.getElementById("feedback").textContent = "Wrong!";
            }
            document.getElementById("score").textContent = `Score: ${score}/${questions.length}`;
        };
        optionsDiv.appendChild(btn);
    });
    document.getElementById("score").textContent = `Score: ${score}/${questions.length}`;
}

document.getElementById("nextBtn").addEventListener("click", function() {
    current++;
    if (current < questions.length) {
        loadQuestion();
    } else {
        document.getElementById("question").textContent = "Quiz Finished!";
        document.getElementById("options").innerHTML = "";
        document.getElementById("feedback").textContent = "";
        document.getElementById("nextBtn").disabled = true;
    }
});

loadQuestion();