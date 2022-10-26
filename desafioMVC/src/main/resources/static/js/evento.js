function remove(tr) {
	tr.remove();
}

const gerarDadosNosDatalists = (e) => {
	e.preventDefault();
	let campoGrupo = document.querySelector("#datalistGrupos");
	let campoAtividade = document.querySelector("#datalistAtividades");
	
	for (let i = 0; i < listaGrupos.length; i++) {
		const nodeInput = document.createElement("option");

		nodeInput.setAttribute('value', listaGrupos[i].nome);

		campoGrupo.appendChild(nodeInput);
	}
	
	for (let i = 0; i < listaAtividades.length; i++) {
		const nodeInput = document.createElement("option");

		nodeInput.setAttribute('value', listaAtividades[i].nome);

		campoAtividade.appendChild(nodeInput);
	}
}

const exibirNaTabelaGrupos = (e) => {
	e.preventDefault();

	var nomeGrupoSelecionado = document.getElementsByName('nameDatalistGrupos')[0];
	var nomeGrupo = nomeGrupoSelecionado.value;

	let campoGrupo = document.querySelector("#campoGrupo");

	const nodeInput = document.createElement("input");
	const nodeTr = document.createElement("tr");
	const nodeTdId = document.createElement("td");
	const nodeTdNome = document.createElement("td");
	const nodeTdNomeParticipante = document.createElement("td");
	const nodeTdNivelParticipante = document.createElement("td");
	const nodeTdVazio = document.createElement("td");
	const nodeButton = document.createElement("button");

	nodeTr.setAttribute('scope', 'row');

	var opcaoExistente = false;

	for (let i = 0; i < listaGrupos.length; i++) {
		if (nomeGrupo == listaGrupos[i].nome) {
			nodeTdId.textContent = listaGrupos[i].id;
			nodeTdNome.textContent = listaGrupos[i].nome;

			var nomesParticipantes = [];
			var niveisParticipantes = [];
			
			for (let j = 0; j < listaGrupos[i].participantes.length; j++) {
				nomesParticipantes.push(listaGrupos[i].participantes[j].nome);
				niveisParticipantes.push(listaGrupos[i].participantes[j].nivel);
			}

			nodeButton.textContent = "Deletar";

			nodeInput.setAttribute('type', 'hidden');
			nodeInput.setAttribute('id', listaGrupos[i]);
			nodeInput.setAttribute('value', listaGrupos[i].id);
			nodeInput.setAttribute('name', 'grupos');
			nodeButton.setAttribute('onClick', 'remove(this.parentNode.parentNode)');

			opcaoExistente = true;
		}
	}

	if (opcaoExistente) {
		campoGrupo.appendChild(nodeTr);
		nodeTr.appendChild(nodeTdId);
		nodeTdId.appendChild(nodeInput);
		nodeTr.appendChild(nodeTdNome);
		nodeTr.appendChild(nodeTdNomeParticipante);
		nodeTr.appendChild(nodeTdNivelParticipante);

		for (let i = 0; i < nomesParticipantes.length; i++) {
			const nodePNomeParticipante = document.createElement("p");
			nodePNomeParticipante.textContent = nomesParticipantes[i];
			nodeTdNomeParticipante.appendChild(nodePNomeParticipante);
			
			const nodePNivelParticipante = document.createElement("p");
			nodePNivelParticipante.textContent = niveisParticipantes[i];
			nodeTdNivelParticipante.appendChild(nodePNivelParticipante);
		}

		nodeTr.appendChild(nodeTdVazio);
		nodeTdVazio.appendChild(nodeButton);
	}
}

const exibirNaTabelaAtividades = (e) => {
	e.preventDefault();

	var nomeAtividadeSelecionada = document.getElementsByName('nameDatalistAtividades')[0];
	var nomeAtividade = nomeAtividadeSelecionada.value;

	let campoAtividade = document.querySelector("#campoAtividade");

	const nodeInput = document.createElement("input");
	const nodeTr = document.createElement("tr");
	const nodeTdId = document.createElement("td");
	const nodeTdNome = document.createElement("td");
	const nodeTdDataInicio = document.createElement("td");
	const nodeTdDataEntrega = document.createElement("td");
	const nodeTdVazio = document.createElement("td");
	const nodeButton = document.createElement("button");

	nodeTr.setAttribute('scope', 'row');

	var opcaoExistente = false;

	for (let i = 0; i < listaAtividades.length; i++) {
		if (nomeAtividade == listaAtividades[i].nome) {
			nodeTdId.textContent = listaAtividades[i].id;
			nodeTdNome.textContent = listaAtividades[i].nome;
			nodeTdDataInicio.textContent = listaAtividades[i].dataInicio;
			nodeTdDataEntrega.textContent = listaAtividades[i].dataEntrega;

			nodeButton.textContent = "Deletar";

			nodeInput.setAttribute('type', 'hidden');
			nodeInput.setAttribute('id', listaAtividades[i]);
			nodeInput.setAttribute('value', listaAtividades[i].id);
			nodeInput.setAttribute('name', 'atividades');
			nodeButton.setAttribute('onClick', 'remove(this.parentNode.parentNode)');

			opcaoExistente = true;
		}
	}

	if (opcaoExistente) {
		campoAtividade.appendChild(nodeTr);
		nodeTr.appendChild(nodeTdId);
		nodeTdId.appendChild(nodeInput);
		nodeTr.appendChild(nodeTdNome);
		nodeTr.appendChild(nodeTdDataInicio);
		nodeTr.appendChild(nodeTdDataEntrega);
		nodeTr.appendChild(nodeTdVazio);
		nodeTdVazio.appendChild(nodeButton);
	}
}

window.addEventListener('load', gerarDadosNosDatalists);

window.onload = function() {
	let button;
	button = document.querySelector("#buttonGrupoEscolhido");
	button.addEventListener('click', exibirNaTabelaGrupos);
	
	button = document.querySelector("#buttonAtividadeEscolhida");
	button.addEventListener('click', exibirNaTabelaAtividades);
}

