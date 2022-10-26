
import React, {Component} from "react";
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';



 export class CreateQuestion extends Component{

  
    

    async  handleSubmit(event) {
        event.preventDefault();
        // const {item} = this.state;
        const questionInput = document.getElementById("question");
        const categoryInput = document.getElementById("Categ");
        const answersInput = document.getElementById("answers");

        console.log(questionInput.value);
        
        const item  =  {
            title: questionInput.value,
            category: categoryInput.value,
            options: answersInput.value,

        }
        const sendthis = [item.title, item.category, item.options];
        

        // console.log(JSON.stringify(sendthis));
        await fetch('http://localhost:8080/api/questions', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        console.log(JSON.stringify(item));
    
        if(Array.isArray(sendthis))
        sendthis.history.push('/questions');
        else
        console.log("Error its not an array");

        
    } 


        render (){
            return(
                //pregunta, categoria, opciones
                <div>
                    <form onSubmit={this.handleSubmit}>
                    <h1>Create question</h1>
                    <Button color="success" id="startquiz" tag={Link} to="/questionForm">Start Quiz</Button>

                    <label>Question:
                    <input type= "text" value="options" id="question"></input>
                    </label>

                    <label  id="category">Category:


                    <select name="cars" id="Categ">
                            <option value= "0" >Yes or no</option>
                            <option value= "1" >1 to 10</option>
                            <option value= "2"  >options</option>
                            </select>
                    </label>

                    <label>Answers (separated by ','):
                    <input type= "text" id ="answers"></input>
                    </label>

                    <button type= "submit" value="submit" id="submit"></button>
                    </form>
                
                </div>
       
        );
    }
}
