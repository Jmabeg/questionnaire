import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { QuestionForm } from './Components/QuestionForm';
import { CreateQuestion } from './Components/CreateQuestion';

function App() {
  return (
    <div className="App">
      <header className="App-header">

        <CreateQuestion/>
        <Routes>
          <Route path='/createQuestion' exact={true} component={<CreateQuestion />}/>
          <Route path='/' exact={true} component={<QuestionForm/>}/>
        </Routes>
   
      </header>
    </div>
  );
}

export default App;
