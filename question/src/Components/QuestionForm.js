import React, {Component} from "react";
import { Button, ButtonGroup, FormGroup, Label, Input } from 'reactstrap';
import { Link } from 'react-router-dom';
import {NavLink} from "react-router-dom";


export class QuestionForm extends Component{


    constructor(props)
    {
        super(props);
       this.state = {
            questions:[],
            actualquestion: 0,          
            anwser1:'',
            anwser2:'',
            anwser3:'',
            anwser4:'',
            anwser5:'', 
            repuesta: '', 
            selitem:'null',
    
        };
    }

    
  
    //Siguiente paso
     NextStep = () =>{

        if(this.state.actualquestion<10)
        {
            const{ actualquestion } = this.state;
            this.setState({actualquestion: actualquestion +1});
            console.log(actualquestion);
        }
                
     
    
    }

    SaveAwnser(respuesta)
    {
            this.state.repuesta = respuesta;
            console.log("Respuesta: "+this.state.repuesta);
    }

    async Save(event) {
        event.preventDefault();
    
        const {item} = this.state;
        console.log(JSON.stringify(item));
        
        await fetch('http://localhost:8080/api/answers' + (this.state.actualquestion ? '/' + this.state.actualquestion : ''), {
            method: (this.state.actualquestion) ? 'PUT' : 'POST',   
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        console.log(JSON.stringify(item));
        this.props.history.push('/answers');
    }





      //id, title, category, answers,
    async componentDidMount() {      
        await fetch('http://localhost:8080/api/questions')
                .then(response => response.json())
                .then ((data) => this.setState({questions: data}));

    }
            
    Asignawnsers = () =>
    {
      return  this.state.questions[this.state.actualquestion].options.split(",");
    }          


    //Handle change fields
    Handlechange = input => e=>{
        this.setState({[input]: e.target.value});
    }

    DisableCheck = option =>
    {
        if(option == "" || option == null)
        return true;
        else
        return false;
    }
  
    render (){

        const {questions, anwser1,anwser2,anwser3,anwser4,anwser5} = this.state;       
        const values = {anwser1,anwser2,anwser3,anwser4,anwser5};
        
      
   

        if(this.state.questions.length != 0 )
        {
            
            if( this.state.questions[this.state.actualquestion].category == 2)
            {
                const answers = this.Asignawnsers();
                values.anwser1 = "";    
                values.anwser2 = "";
                values.anwser3 = "";
                values.anwser4 = "";
                values.anwser5 = "";

                for(var i=0; i<answers.length; i++)
                {
                    if(i=0)
                    values.anwser1 = answers[i];
                    if(i=1)
                    values.anwser2 = answers[i];
                    if(i=2)
                    values.anwser3 = answers[i];
                    if(i=3)
                    values.anwser4 = answers[i];
                    if(i=4)
                    values.anwser5 = answers[i];
                            
                }
            }
        }



    return(
        <>
            { this.state.questions.length === 0 ?        
                <div>Loading...</div> :
                this.state.questions[this.state.actualquestion].category === 0 ?  
                //primera opcion 
                <div>
                    <FormGroup>  
                        <Button color="success" component={Link} to="/createQuestion"> Create new question</Button>
                        <h1 id = "ActualQuestion">
                            Pregunta: {this.state.questions[this.state.actualquestion].title}
                        </h1>

                        <Label for="cbox">Yes</Label>
                        <Input type="radio" name= "cbox" id="cbox1" value="Yes" onChange={() =>{this.SaveAwnser("Yes")}} ></Input>
                
                        <Label for="cbox">No</Label>
                        <Input type="radio" name= "cbox" id="cbox2" value="No"  onChange = {() =>{this.SaveAwnser("No")}} ></Input>

                        <Button color="success" onClick={() =>{this.Save.bind(this);this.NextStep()}}>Next</Button   > 
                    </FormGroup>
                </div>:

                this.state.questions[this.state.actualquestion].category === 1 ?  //segunda opcion
                
                <div>
                    <h1 id = "ActualQuestion">
                        Pregunta: {this.state.questions[this.state.actualquestion].title}
                    </h1>

                    <h4>{1}</h4>
                    <input type="radio" name= "cbox" id="cbox1" value={1}></input>

                    <h4>{2}</h4>
                    <input type="radio" name= "cbox" id="cbox2" value={2}></input>

                    <h4>{3}</h4>
                    <input type="radio" name= "cbox" id="cbox3" value={3}></input>

                    <h4>{4}</h4>
                    <input type="radio" name= "cbox" id="cbox4" value={4}></input>

                    <h4>{5}</h4>
                    <input type="radio" name= "cbox" id="cbox5" value={5}></input>

                    <h4>{6}</h4>
                    <input type="radio" name= "cbox" id="cbox6" value={6}></input>

                    <h4>{7}</h4>
                    <input type="radio" name= "cbox" id="cbox7" value={7}></input>

                    <h4>{8}</h4>
                    <input type="radio" name= "cbox" id="cbox8" value={8}></input>

                    <h4>{9}</h4>
                    <input type="radio" name= "cbox"id="cbox9" value={9}></input>

                    <h4>{10}</h4>
                    <input type="radio" name= "cbox" id="cbox10" value={10}></input>
                
                   
                    <button onClick={() =>{this.Save.bind(this);this.NextStep()}}>Next</button> 
                </div>:

                            
                <div> // Tercera opcion
                    
                    {this.state.questions.map(question => {
                        <div>
                  
                        </div>
                    })}
                      

                    <h1 id = "ActualQuestion">
                        Pregunta: {this.state.questions[this.state.actualquestion].title}
                    </h1>

                    <h4>{values.anwser1}</h4>
                    <input type="radio" name= "cbox" id="cbox1" value={values.anwser1}
                    hidden= {this.DisableCheck(values.anwser1)}  ></input>
                
                    <h4>{values.anwser2}</h4>
                    <input type="radio" name= "cbox" id="cbox2" value={values.anwser2}
                    hidden= {this.DisableCheck(values.anwser2)}></input>
                
                    <h4>{values.anwser3}</h4>
                    <input type="radio" name= "cbox" id="cbox3" value={values.anwser3}
                    hidden= {this.DisableCheck(values.anwser3)}></input>
                
                    <h4>{values.anwser4}</h4>
                    <input type="radio" name= "cbox" id="cbox4" value={values.anwser4} 
                    hidden= {this.DisableCheck(values.anwser4)}></input>

                    <h4>{values.anwser5}</h4>
                    <input type="radio" name= "cbox" id="cbox5" value={values.anwser5}
                    hidden= {this.DisableCheck(values.anwser5)}></input>
                

                    <button id="submit"  onClick={() =>{this.Save.bind(this);this.NextStep()}}>Next</button> 
            
                </div>
            }
        </>
    )

};

  
    }

