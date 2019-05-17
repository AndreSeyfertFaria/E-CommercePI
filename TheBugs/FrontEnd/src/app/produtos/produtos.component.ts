import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../produto.service';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html',
  styleUrls: ['./produtos.component.css']
})
export class ProdutosComponent implements OnInit {

  produtos: Array<any>;

  constructor(private produtoService: ProdutoService) { }

  ngOnInit() {
    this.listar();
  }

  listar () {
    this.produtoService.listar().subscribe(dados => this.produtos = dados);
  }
}
