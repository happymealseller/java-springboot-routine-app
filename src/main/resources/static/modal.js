	const modal = document.getElementById("modal");
	const trigger = document.getElementById("modal-trigger");
	const closeBtn = modal.querySelector(".close");

	trigger.addEventListener("click", function() {
	  modal.style.display = "block";
	});
	
	closeBtn.addEventListener("click", function() {
	  modal.style.display = "none";
	});
	
	window.addEventListener("click", function(event) {
	  if (event.target === modal) {
	    modal.style.display = "none";
	  }
	});