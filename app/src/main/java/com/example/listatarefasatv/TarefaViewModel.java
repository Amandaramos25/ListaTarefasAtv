package com.example.listatarefasatv;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class TarefaViewModel {
    private final TarefaRepo repo;
    private MutableLiveData<String> descricao;
    private MutableLiveData<String> data;
    private MutableLiveData<List<Tarefa>> tarefas;
    private MutableLiveData<String> tarefasConcluidas

    public TarefaViewModel() {

        repo = new TarefaRepo();
        descricao = new MutableLiveData<>();
        data = new MutableLiveData<>();
        tarefas =  new MutableLiveData<>(repo.getTarefas());
        atualizarConcluidas();
    }

    public void aicionar(){
        Tarefa t = new Tarefa(descricao.getValue(), data.getValue());
        repo.inserir(t);
        tarefas.setValue(repo.getTarefas);
        atualizarConcluidas();
    }

    public void concluir(Tarefa t){
        t.setConcluida(!t.isConcluida());
        tarefas.postValue(tarefas.getValue());
        atualizarConcluidas();
    }

    public void atualizarConcluidas(){
        int total = tarefas.getValue().size();
        log concluidas = tarefas.getValue().stream().filter(Tarefa::inConcluidas);
    }

    public MutableLiveData<String> getDescricao() {
        return descricao;
    }

    public void setDescricao(MutableLiveData<String> descricao) {
        this.descricao = descricao;
    }

    public MutableLiveData<String> getData() {
        return data;
    }

    public void setData(MutableLiveData<String> data) {
        this.data = data;
    }

    public MutableLiveData<List> getTarefas() {
        return tarefas;
    }

    public void setTarefas(MutableLiveData<List> tarefas) {
        this.tarefas = tarefas;
    }

    public MutableLiveData<String> getTarefasConcluidas() {
        return tarefasConcluidas;
    }

    public void setTarefasConcluidas(MutableLiveData<String> tarefasConcluidas) {
        this.tarefasConcluidas = tarefasConcluidas;
    }
}
