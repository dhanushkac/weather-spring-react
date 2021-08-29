const InformationBlock = ({info, error}) => {

  if(error) {
    return <div>
      *Sorry, but we could not identify the city name. Please check if it's spelled correctly.*
    </div>
  }

  if (!info) {
    return null;
  }

  let timeFormatter = new Intl.DateTimeFormat("en" , {
    timeStyle: "short",
    hourCycle: 'h24'
  });

  let dateFormatter = new Intl.DateTimeFormat("en" , {
    month: "short",
    day: "numeric"
  });

  return <>
    <div>Weather in { info.cityName }, { info.countryCode } ( { dateFormatter.format(new Date(info.dateTime)) }, { timeFormatter.format(new Date(info.dateTime)) } )</div>
    <div>Current temp: { info.currentTemperature } °C - { info.status }</div>
    <div>Minimum temp today: { info.minTemperature } °C</div>
    <div>Maximum temp today: { info.maxTemperature } °C</div>
  </>;
}

export default InformationBlock;

//Jul 12, 13:43