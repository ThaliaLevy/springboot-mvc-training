const gerarDadosNoDatalistEventos = (e) => {
	e.preventDefault();
	let campoEvento = document.querySelector("#datalistEventos");

	for (let i = 0; i < listaEventos.length; i++) {
		const nodeInput = document.createElement("option");
		nodeInput.setAttribute('value', listaEventos[i].nome);
		campoEvento.appendChild(nodeInput);
	}
}

const gerarDadosNoDatalistAtividades = (e) => {
	e.preventDefault();

	var nomeEventoSelecionado = document.getElementsByName('nameDatalistEventos')[0];
	var nomeEvento = nomeEventoSelecionado.value;
	let campoAtividade = document.querySelector("#datalistAtividades");
	let campoGrupo = document.querySelector("#datalistGrupos");
	document.getElementById('inputAtividades').removeAttribute('disabled');

	for (let i = 0; i < listaEventos.length; i++) {
		if (nomeEvento == listaEventos[i].nome) {
			for (let j = 0; j < listaEventos[i].atividades.length; j++) {
				nodeInput = document.createElement("option");
				nodeInput.setAttribute('value', listaEventos[i].atividades[j].nome);
				campoAtividade.appendChild(nodeInput);
			}

			for (let j = 0; j < listaEventos[i].grupos.length; j++) {
				nodeInput = document.createElement("option");
				nodeInput.setAttribute('value', listaEventos[i].grupos[j].nome);
				campoGrupo.appendChild(nodeInput);
			}
		}
	}
}

const exibirDadosNoDatalistGrupos = (e) => {
	e.preventDefault();

	document.getElementById('inputGrupos').removeAttribute('disabled');
}


var idEvento;
var valueEvento;

const exibirDadosNaTabela = (e) => {
	e.preventDefault();

	var nomeGrupoSelecionado = document.getElementsByName('nameDatalistGrupos')[0];
	var nomeGrupo = nomeGrupoSelecionado.value;
	var nomeEventoSelecionado = document.getElementsByName('nameDatalistEventos')[0];
	var nomeEvento = nomeEventoSelecionado.value;

	let campoGrupo = document.querySelector("#campoGrupo");
	const nodeInput = document.createElement("input");

	var opcaoExistente = false;
	var nomesParticipantes = [];
	var idsParticipantes = [];

	for (let i = 0; i < listaEventos.length; i++) {
		if (nomeEvento == listaEventos[i].nome) {

			idEvento = listaEventos[i];
			valueEvento = listaEventos[i].id;
			for (let j = 0; j < listaEventos[i].grupos.length; j++) {
				if (nomeGrupo == listaEventos[i].grupos[j].nome) {
					for (let k = 0; k < listaEventos[i].grupos[j].participantes.length; k++) {
						nomesParticipantes.push(listaEventos[i].grupos[j].participantes[k].nome);
						idsParticipantes.push(listaEventos[i].grupos[j].participantes[k].id);
					}

					nodeInput.setAttribute('type', 'hidden');
					nodeInput.setAttribute('id', listaEventos[i]);
					nodeInput.setAttribute('value', listaEventos[i].id);
					nodeInput.setAttribute('name', 'eventos');

					opcaoExistente = true;
				}
			}
		}
	}

	if (opcaoExistente) {
		for (let i = 0; i < nomesParticipantes.length; i++) {
			const nodeTr = document.createElement("tr");
			const nodeTdNomeParticipante = document.createElement("td");
			const nodeTdAtividadeEntregue = document.createElement("td");
			const nodeCheckboxAtividadeEntregue = document.createElement("input");
			const nodeTdEntregaAtrasada = document.createElement("td");
			const nodeCheckboxEntregaAtrasada = document.createElement("input");

			nodeCheckboxAtividadeEntregue.setAttribute('type', 'checkbox');
			nodeCheckboxAtividadeEntregue.setAttribute('name', 'atividadeEntregue');
			nodeCheckboxEntregaAtrasada.setAttribute('type', 'checkbox');
			nodeCheckboxEntregaAtrasada.setAttribute('name', 'entregaAtrasada');

			nodeTdNomeParticipante.textContent = nomesParticipantes[i];

			campoGrupo.appendChild(nodeTr);
			nodeTr.appendChild(nodeTdNomeParticipante);
			nodeTr.appendChild(nodeTdAtividadeEntregue);
			nodeTdAtividadeEntregue.appendChild(nodeCheckboxAtividadeEntregue);
			nodeTr.appendChild(nodeTdEntregaAtrasada);
			nodeTdEntregaAtrasada.appendChild(nodeCheckboxEntregaAtrasada);
		}

		const nodeTrInput = document.createElement("tr");
		const nodeTdInput = document.createElement("td");

		campoGrupo.appendChild(nodeTrInput);
		nodeTrInput.appendChild(nodeTdInput);
		nodeTdInput.appendChild(nodeInput);
	}
}

const gravarDadosCheckbox = () => {

	nodeCheckboxEntregaAtrasada.setAttribute('type', 'checkbox');


	/* nodeInput.setAttribute('id', listaEventos[i]);
					nodeInput.setAttribute('value', listaEventos[i].id);
					nodeInput.setAttribute('name', 'eventos'); */
}

window.addEventListener('load', gerarDadosNoDatalistEventos);

window.onload = function() {
	let button;
	button = document.querySelector("#buttonEventoEscolhido");
	button.addEventListener('click', gerarDadosNoDatalistAtividades);

	button = document.querySelector("#buttonAtividadeEscolhida");
	button.addEventListener('click', exibirDadosNoDatalistGrupos);

	button = document.querySelector("#buttonGrupoEscolhido");
	button.addEventListener('click', exibirDadosNaTabela);
}
