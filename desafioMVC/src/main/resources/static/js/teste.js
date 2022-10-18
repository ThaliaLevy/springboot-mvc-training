console.log("oiiiiiii");
	
	const gerarInput = (e) => {
		e.preventDefault();
		let campo = document.querySelector("#teste");
		let number = document.querySelector("#entrada").value;
		
		console.log(number);
		
		for(let i = 0; i < number; i++){
			const nodeInput = document.createElement("input");
			
			campo.appendChild(nodeInput);
		}
		
		
	}
	
	let button = document.querySelector("#button");
		button.addEventListener('click', gerarInput);