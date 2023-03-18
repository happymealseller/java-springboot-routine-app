	// Get the modals and buttons
	// Get the modals and buttons
const modal = document.getElementById("modal");
const trigger = document.getElementById("modal-trigger");

const modal2 = document.getElementById("modal-2");
const trigger2 = document.getElementById("modal-trigger-2");

// Get the close buttons
const closeBtn = modal.querySelector(".close");
const closeBtn2 = modal2.querySelector(".close-2");

// When the user clicks the button, open the modal
trigger.addEventListener("click", function() {
  modal.style.display = "block";
});

trigger2.addEventListener("click", function() {
  modal2.style.display = "block";
});

// When the user clicks on the close button, close the modal
closeBtn.addEventListener("click", function() {
  modal.style.display = "none";
});

closeBtn2.addEventListener("click", function() {
  modal2.style.display = "none";
});

// When the user clicks anywhere outside of the modal, close it
window.addEventListener("click", function(event) {
  if (event.target === modal) {
    modal.style.display = "none";
  } else if (event.target === modal2) {
    modal2.style.display = "none";
  }
});



	// Get all the task cards
	const taskCards = document.querySelectorAll(".task-card");

	// Loop through each task card
	taskCards.forEach(function(taskCard) {
	  // Get the task duration and status elements
	  const durationElem = taskCard.querySelector(".task-duration p");
	  const statusElem = taskCard.querySelector(".task-status p");
	  const duration = parseInt(durationElem.textContent);

	  // Create a button and add it to the task card
	  const button = document.querySelector(".fake-btn");
	  button.addEventListener("click", function() {
	    // Set the initial task status to "In Progress"
	    statusElem.textContent = "start";

	    // Set the countdown timer
	    let timer = duration * 60;
	    let minutes, seconds;
	    const countdown = setInterval(function() {
	      // Calculate the minutes and seconds remaining
	      minutes = Math.floor(timer / 60);
	      seconds = timer % 60;

	      // Update the duration element with the remaining time
	      durationElem.textContent = minutes + "m " + seconds + "s";

	      // Update the task status element every minute
	      if (timer % 60 === 0) {
	        const minutesRemaining = timer / 60;
	        statusElem.textContent = minutesRemaining + " min ";
	      }

	      // Decrement the timer
	      timer--;

	      // When the timer reaches 0, update the task status to "Completed"
	      if (timer < 0) {
	        clearInterval(countdown);
	        durationElem.textContent = duration + "m";
	        statusElem.textContent = "Completed";
	      }
	    }, 1000);
	  });
	});
	