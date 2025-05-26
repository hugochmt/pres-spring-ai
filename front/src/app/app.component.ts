import { Component, inject } from '@angular/core';
import { FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { finalize } from 'rxjs';

type Message = {
  content: string;
  author: 'user' | 'ai';
};

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [FormsModule, ReactiveFormsModule],
})
export class AppComponent {
  private httpClient = inject(HttpClient);

  messageControl = new FormControl('');
  messages: Message[] = [];
  isLoading = false;

  sendMessage() {
    const userInput = this.messageControl.value;

    this.messages.push({
      content: userInput ?? '',
      author: 'user',
    });

    this.isLoading = true;

    this.httpClient
      .post('http://localhost:8080/ai-chat', userInput, { responseType: 'text' })
      .pipe(finalize(() => (this.isLoading = false)))
      .subscribe(res => {
        this.messages.push({
          content: res,
          author: 'ai',
        });
        this.messageControl.setValue('');
      });
  }
}
