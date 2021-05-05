import { Tema } from './Tema';
import { User } from './User';

export class Postagem {
  public id: number
  public titulo: string
  public data: Date
  public texto: string
  public midia: string
  public usuario: User
  public tema: Tema
}
