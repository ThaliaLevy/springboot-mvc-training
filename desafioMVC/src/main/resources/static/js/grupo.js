function remove(tr) {
	tr.remove();
	var quantidadePessoasConvertidoParaInt = document.getElementById("quantidadePessoas").value;
	document.getElementById("quantidadePessoas").value = parseInt(quantidadePessoasConvertidoParaInt) - 1;
}



const gerarInput = (e) => {
	e.preventDefault();
	let campo = document.querySelector("#datalistParticipantes");

	for (let i = 0; i < listaParticipantes.length; i++) {
		const nodeInput = document.createElement("option");

		nodeInput.setAttribute('value', listaParticipantes[i].nome);

		campo.appendChild(nodeInput);
	}
}

const exibirNaTabela = (e) => {
	e.preventDefault();

	var nomeParticipante = document.getElementsByName('nameDatalistParticipantes')[0];
	var nomeParticipanteInserido = nomeParticipante.value;
	
	let campo = document.querySelector("#campo");

	const nodeInput = document.createElement("input");
	const nodeTr = document.createElement("tr");
	const nodeTdId = document.createElement("td");
	const nodeTdNome = document.createElement("td");
	const nodeTdEmail = document.createElement("td");
	const nodeTdQuatroLetras = document.createElement("td");
	const nodeTdNivel = document.createElement("td");
	const nodeTdVazio = document.createElement("td");
	const nodeButton = document.createElement("button");

	nodeTr.setAttribute('scope', 'row');

	var opcaoExistente = false;

	for (let i = 0; i < listaParticipantes.length; i++) {
		if (nomeParticipanteInserido == listaParticipantes[i].nome) {
			nodeTdNome.textContent = listaParticipantes[i].nome;
			nodeTdEmail.textContent = listaParticipantes[i].email;
			nodeTdQuatroLetras.textContent = listaParticipantes[i].quatroLetras;
			nodeTdNivel.textContent = listaParticipantes[i].nivel;
			nodeButton.textContent = "Deletar";

			nodeInput.setAttribute('type', 'hidden');
			nodeInput.setAttribute('id', listaParticipantes[i]);
			nodeInput.setAttribute('value', listaParticipantes[i].id);
			nodeInput.setAttribute('name', 'participantes');
			nodeButton.setAttribute('onClick', 'remove(this.parentNode.parentNode)');

			var quantidadePessoasConvertidoParaInt = document.getElementById("quantidadePessoas").value;
			document.getElementById("quantidadePessoas").value = parseInt(quantidadePessoasConvertidoParaInt) + 1;

			opcaoExistente = true;
		}
	}

	if (opcaoExistente) {
		campo.appendChild(nodeTr);
		nodeTr.appendChild(nodeTdId);
		nodeTdId.appendChild(nodeInput);
		nodeTr.appendChild(nodeTdNome);
		nodeTr.appendChild(nodeTdEmail);
		nodeTr.appendChild(nodeTdQuatroLetras);
		nodeTr.appendChild(nodeTdNivel);
		nodeTr.appendChild(nodeTdVazio);
		nodeTdVazio.appendChild(nodeButton);
	}
}

window.addEventListener('load', gerarInput);

window.onload = function() {
	let button = document.querySelector("#button");
	button.addEventListener('click', exibirNaTabela);


}