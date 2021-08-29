import './App.css';
import SearchBox from './components/SearchBox';
import InformationBlock from './components/InformationBlock';
import { useState } from 'react';

function App() {

  const [weatherInfo, setWeatherInfo] = useState(null);
  const [error, setError] = useState(false);

  const OnSendResult = (res) =>{
    setWeatherInfo(res.data);
    setError(res.error);
  }

  return (
    <>
    <SearchBox sendResult={OnSendResult}/>
    <InformationBlock info={weatherInfo} error={error}/>
    </>
  );
}

export default App;
